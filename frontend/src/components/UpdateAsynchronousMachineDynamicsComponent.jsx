import React, { Component } from 'react'
import AsynchronousMachineDynamicsService from '../services/AsynchronousMachineDynamicsService';

class UpdateAsynchronousMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAsynchronousMachineDynamics = this.updateAsynchronousMachineDynamics.bind(this);

    }

    componentDidMount(){
        AsynchronousMachineDynamicsService.getAsynchronousMachineDynamicsById(this.state.id).then( (res) =>{
            let asynchronousMachineDynamics = res.data;
            this.setState({
            });
        });
    }

    updateAsynchronousMachineDynamics = (e) => {
        e.preventDefault();
        let asynchronousMachineDynamics = {
            asynchronousMachineDynamicsId: this.state.id,
        };
        console.log('asynchronousMachineDynamics => ' + JSON.stringify(asynchronousMachineDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineDynamicsService.updateAsynchronousMachineDynamics(asynchronousMachineDynamics).then( res => {
            this.props.history.push('/asynchronousMachineDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/asynchronousMachineDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachineDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachineDynamics}>Save</button>
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

export default UpdateAsynchronousMachineDynamicsComponent
