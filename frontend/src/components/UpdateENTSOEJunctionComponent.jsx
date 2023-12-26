import React, { Component } from 'react'
import ENTSOEJunctionService from '../services/ENTSOEJunctionService';

class UpdateENTSOEJunctionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateENTSOEJunction = this.updateENTSOEJunction.bind(this);

    }

    componentDidMount(){
        ENTSOEJunctionService.getENTSOEJunctionById(this.state.id).then( (res) =>{
            let eNTSOEJunction = res.data;
            this.setState({
            });
        });
    }

    updateENTSOEJunction = (e) => {
        e.preventDefault();
        let eNTSOEJunction = {
            eNTSOEJunctionId: this.state.id,
        };
        console.log('eNTSOEJunction => ' + JSON.stringify(eNTSOEJunction));
        console.log('id => ' + JSON.stringify(this.state.id));
        ENTSOEJunctionService.updateENTSOEJunction(eNTSOEJunction).then( res => {
            this.props.history.push('/eNTSOEJunctions');
        });
    }


    cancel(){
        this.props.history.push('/eNTSOEJunctions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ENTSOEJunction</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateENTSOEJunction}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateENTSOEJunctionComponent
