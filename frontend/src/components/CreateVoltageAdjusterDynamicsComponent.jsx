import React, { Component } from 'react'
import VoltageAdjusterDynamicsService from '../services/VoltageAdjusterDynamicsService';

class CreateVoltageAdjusterDynamicsComponent extends Component {
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
            VoltageAdjusterDynamicsService.getVoltageAdjusterDynamicsById(this.state.id).then( (res) =>{
                let voltageAdjusterDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateVoltageAdjusterDynamics = (e) => {
        e.preventDefault();
        let voltageAdjusterDynamics = {
                voltageAdjusterDynamicsId: this.state.id,
            };
        console.log('voltageAdjusterDynamics => ' + JSON.stringify(voltageAdjusterDynamics));

        // step 5
        if(this.state.id === '_add'){
            voltageAdjusterDynamics.voltageAdjusterDynamicsId=''
            VoltageAdjusterDynamicsService.createVoltageAdjusterDynamics(voltageAdjusterDynamics).then(res =>{
                this.props.history.push('/voltageAdjusterDynamicss');
            });
        }else{
            VoltageAdjusterDynamicsService.updateVoltageAdjusterDynamics(voltageAdjusterDynamics).then( res => {
                this.props.history.push('/voltageAdjusterDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/voltageAdjusterDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltageAdjusterDynamics</h3>
        }else{
            return <h3 className="text-center">Update VoltageAdjusterDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltageAdjusterDynamics}>Save</button>
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

export default CreateVoltageAdjusterDynamicsComponent
