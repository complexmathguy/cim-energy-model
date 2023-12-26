import React, { Component } from 'react'
import SynchronousMachineDynamicsService from '../services/SynchronousMachineDynamicsService';

class UpdateSynchronousMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSynchronousMachineDynamics = this.updateSynchronousMachineDynamics.bind(this);

    }

    componentDidMount(){
        SynchronousMachineDynamicsService.getSynchronousMachineDynamicsById(this.state.id).then( (res) =>{
            let synchronousMachineDynamics = res.data;
            this.setState({
            });
        });
    }

    updateSynchronousMachineDynamics = (e) => {
        e.preventDefault();
        let synchronousMachineDynamics = {
            synchronousMachineDynamicsId: this.state.id,
        };
        console.log('synchronousMachineDynamics => ' + JSON.stringify(synchronousMachineDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineDynamicsService.updateSynchronousMachineDynamics(synchronousMachineDynamics).then( res => {
            this.props.history.push('/synchronousMachineDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/synchronousMachineDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineDynamics}>Save</button>
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

export default UpdateSynchronousMachineDynamicsComponent
