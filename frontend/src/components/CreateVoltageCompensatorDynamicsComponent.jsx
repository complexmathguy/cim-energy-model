import React, { Component } from 'react'
import VoltageCompensatorDynamicsService from '../services/VoltageCompensatorDynamicsService';

class CreateVoltageCompensatorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VoltageCompensatorDynamicsService.getVoltageCompensatorDynamicsById(this.state.id).then( (res) =>{
                let voltageCompensatorDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateVoltageCompensatorDynamics = (e) => {
        e.preventDefault();
        let voltageCompensatorDynamics = {
                voltageCompensatorDynamicsId: this.state.id,
            };
        console.log('voltageCompensatorDynamics => ' + JSON.stringify(voltageCompensatorDynamics));

        // step 5
        if(this.state.id === '_add'){
            voltageCompensatorDynamics.voltageCompensatorDynamicsId=''
            VoltageCompensatorDynamicsService.createVoltageCompensatorDynamics(voltageCompensatorDynamics).then(res =>{
                this.props.history.push('/voltageCompensatorDynamicss');
            });
        }else{
            VoltageCompensatorDynamicsService.updateVoltageCompensatorDynamics(voltageCompensatorDynamics).then( res => {
                this.props.history.push('/voltageCompensatorDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/voltageCompensatorDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltageCompensatorDynamics</h3>
        }else{
            return <h3 className="text-center">Update VoltageCompensatorDynamics</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltageCompensatorDynamics}>Save</button>
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

export default CreateVoltageCompensatorDynamicsComponent
