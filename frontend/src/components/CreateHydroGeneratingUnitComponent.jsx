import React, { Component } from 'react'
import HydroGeneratingUnitService from '../services/HydroGeneratingUnitService';

class CreateHydroGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                energyConversionCapability: ''
        }
        this.changeenergyConversionCapabilityHandler = this.changeenergyConversionCapabilityHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            HydroGeneratingUnitService.getHydroGeneratingUnitById(this.state.id).then( (res) =>{
                let hydroGeneratingUnit = res.data;
                this.setState({
                    energyConversionCapability: hydroGeneratingUnit.energyConversionCapability
                });
            });
        }        
    }
    saveOrUpdateHydroGeneratingUnit = (e) => {
        e.preventDefault();
        let hydroGeneratingUnit = {
                hydroGeneratingUnitId: this.state.id,
                energyConversionCapability: this.state.energyConversionCapability
            };
        console.log('hydroGeneratingUnit => ' + JSON.stringify(hydroGeneratingUnit));

        // step 5
        if(this.state.id === '_add'){
            hydroGeneratingUnit.hydroGeneratingUnitId=''
            HydroGeneratingUnitService.createHydroGeneratingUnit(hydroGeneratingUnit).then(res =>{
                this.props.history.push('/hydroGeneratingUnits');
            });
        }else{
            HydroGeneratingUnitService.updateHydroGeneratingUnit(hydroGeneratingUnit).then( res => {
                this.props.history.push('/hydroGeneratingUnits');
            });
        }
    }
    
    changeenergyConversionCapabilityHandler= (event) => {
        this.setState({energyConversionCapability: event.target.value});
    }

    cancel(){
        this.props.history.push('/hydroGeneratingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add HydroGeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update HydroGeneratingUnit</h3>
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
                                            <label> energyConversionCapability: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateHydroGeneratingUnit}>Save</button>
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

export default CreateHydroGeneratingUnitComponent
