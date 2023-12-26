import React, { Component } from 'react'
import ThermalGeneratingUnitService from '../services/ThermalGeneratingUnitService';

class CreateThermalGeneratingUnitComponent extends Component {
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
            ThermalGeneratingUnitService.getThermalGeneratingUnitById(this.state.id).then( (res) =>{
                let thermalGeneratingUnit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateThermalGeneratingUnit = (e) => {
        e.preventDefault();
        let thermalGeneratingUnit = {
                thermalGeneratingUnitId: this.state.id,
            };
        console.log('thermalGeneratingUnit => ' + JSON.stringify(thermalGeneratingUnit));

        // step 5
        if(this.state.id === '_add'){
            thermalGeneratingUnit.thermalGeneratingUnitId=''
            ThermalGeneratingUnitService.createThermalGeneratingUnit(thermalGeneratingUnit).then(res =>{
                this.props.history.push('/thermalGeneratingUnits');
            });
        }else{
            ThermalGeneratingUnitService.updateThermalGeneratingUnit(thermalGeneratingUnit).then( res => {
                this.props.history.push('/thermalGeneratingUnits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/thermalGeneratingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ThermalGeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update ThermalGeneratingUnit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateThermalGeneratingUnit}>Save</button>
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

export default CreateThermalGeneratingUnitComponent
