import React, { Component } from 'react'
import PowerSystemStabilizerDynamicsService from '../services/PowerSystemStabilizerDynamicsService';

class CreatePowerSystemStabilizerDynamicsComponent extends Component {
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
            PowerSystemStabilizerDynamicsService.getPowerSystemStabilizerDynamicsById(this.state.id).then( (res) =>{
                let powerSystemStabilizerDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePowerSystemStabilizerDynamics = (e) => {
        e.preventDefault();
        let powerSystemStabilizerDynamics = {
                powerSystemStabilizerDynamicsId: this.state.id,
            };
        console.log('powerSystemStabilizerDynamics => ' + JSON.stringify(powerSystemStabilizerDynamics));

        // step 5
        if(this.state.id === '_add'){
            powerSystemStabilizerDynamics.powerSystemStabilizerDynamicsId=''
            PowerSystemStabilizerDynamicsService.createPowerSystemStabilizerDynamics(powerSystemStabilizerDynamics).then(res =>{
                this.props.history.push('/powerSystemStabilizerDynamicss');
            });
        }else{
            PowerSystemStabilizerDynamicsService.updatePowerSystemStabilizerDynamics(powerSystemStabilizerDynamics).then( res => {
                this.props.history.push('/powerSystemStabilizerDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/powerSystemStabilizerDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PowerSystemStabilizerDynamics</h3>
        }else{
            return <h3 className="text-center">Update PowerSystemStabilizerDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePowerSystemStabilizerDynamics}>Save</button>
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

export default CreatePowerSystemStabilizerDynamicsComponent
