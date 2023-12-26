import React, { Component } from 'react'
import VoltageAdjusterDynamicsService from '../services/VoltageAdjusterDynamicsService';

class UpdateVoltageAdjusterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateVoltageAdjusterDynamics = this.updateVoltageAdjusterDynamics.bind(this);

    }

    componentDidMount(){
        VoltageAdjusterDynamicsService.getVoltageAdjusterDynamicsById(this.state.id).then( (res) =>{
            let voltageAdjusterDynamics = res.data;
            this.setState({
            });
        });
    }

    updateVoltageAdjusterDynamics = (e) => {
        e.preventDefault();
        let voltageAdjusterDynamics = {
            voltageAdjusterDynamicsId: this.state.id,
        };
        console.log('voltageAdjusterDynamics => ' + JSON.stringify(voltageAdjusterDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageAdjusterDynamicsService.updateVoltageAdjusterDynamics(voltageAdjusterDynamics).then( res => {
            this.props.history.push('/voltageAdjusterDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/voltageAdjusterDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltageAdjusterDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltageAdjusterDynamics}>Save</button>
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

export default UpdateVoltageAdjusterDynamicsComponent
