import React, { Component } from 'react'
import BayService from '../services/BayService';

class UpdateBayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateBay = this.updateBay.bind(this);

    }

    componentDidMount(){
        BayService.getBayById(this.state.id).then( (res) =>{
            let bay = res.data;
            this.setState({
            });
        });
    }

    updateBay = (e) => {
        e.preventDefault();
        let bay = {
            bayId: this.state.id,
        };
        console.log('bay => ' + JSON.stringify(bay));
        console.log('id => ' + JSON.stringify(this.state.id));
        BayService.updateBay(bay).then( res => {
            this.props.history.push('/bays');
        });
    }


    cancel(){
        this.props.history.push('/bays');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Bay</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBay}>Save</button>
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

export default UpdateBayComponent
