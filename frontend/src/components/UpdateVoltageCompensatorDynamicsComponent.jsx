import React, { Component } from 'react'
import VoltageCompensatorDynamicsService from '../services/VoltageCompensatorDynamicsService';

class UpdateVoltageCompensatorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateVoltageCompensatorDynamics = this.updateVoltageCompensatorDynamics.bind(this);

    }

    componentDidMount(){
        VoltageCompensatorDynamicsService.getVoltageCompensatorDynamicsById(this.state.id).then( (res) =>{
            let voltageCompensatorDynamics = res.data;
            this.setState({
            });
        });
    }

    updateVoltageCompensatorDynamics = (e) => {
        e.preventDefault();
        let voltageCompensatorDynamics = {
            voltageCompensatorDynamicsId: this.state.id,
        };
        console.log('voltageCompensatorDynamics => ' + JSON.stringify(voltageCompensatorDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageCompensatorDynamicsService.updateVoltageCompensatorDynamics(voltageCompensatorDynamics).then( res => {
            this.props.history.push('/voltageCompensatorDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/voltageCompensatorDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltageCompensatorDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltageCompensatorDynamics}>Save</button>
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

export default UpdateVoltageCompensatorDynamicsComponent
