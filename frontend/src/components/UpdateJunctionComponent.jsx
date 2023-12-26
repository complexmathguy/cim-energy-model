import React, { Component } from 'react'
import JunctionService from '../services/JunctionService';

class UpdateJunctionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateJunction = this.updateJunction.bind(this);

    }

    componentDidMount(){
        JunctionService.getJunctionById(this.state.id).then( (res) =>{
            let junction = res.data;
            this.setState({
            });
        });
    }

    updateJunction = (e) => {
        e.preventDefault();
        let junction = {
            junctionId: this.state.id,
        };
        console.log('junction => ' + JSON.stringify(junction));
        console.log('id => ' + JSON.stringify(this.state.id));
        JunctionService.updateJunction(junction).then( res => {
            this.props.history.push('/junctions');
        });
    }


    cancel(){
        this.props.history.push('/junctions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Junction</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateJunction}>Save</button>
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

export default UpdateJunctionComponent
