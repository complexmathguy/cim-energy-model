import React, { Component } from 'react'
import HydroPowerPlantService from '../services/HydroPowerPlantService';

class CreateHydroPowerPlantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                hydroPlantStorageType: ''
        }
        this.changehydroPlantStorageTypeHandler = this.changehydroPlantStorageTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            HydroPowerPlantService.getHydroPowerPlantById(this.state.id).then( (res) =>{
                let hydroPowerPlant = res.data;
                this.setState({
                    hydroPlantStorageType: hydroPowerPlant.hydroPlantStorageType
                });
            });
        }        
    }
    saveOrUpdateHydroPowerPlant = (e) => {
        e.preventDefault();
        let hydroPowerPlant = {
                hydroPowerPlantId: this.state.id,
                hydroPlantStorageType: this.state.hydroPlantStorageType
            };
        console.log('hydroPowerPlant => ' + JSON.stringify(hydroPowerPlant));

        // step 5
        if(this.state.id === '_add'){
            hydroPowerPlant.hydroPowerPlantId=''
            HydroPowerPlantService.createHydroPowerPlant(hydroPowerPlant).then(res =>{
                this.props.history.push('/hydroPowerPlants');
            });
        }else{
            HydroPowerPlantService.updateHydroPowerPlant(hydroPowerPlant).then( res => {
                this.props.history.push('/hydroPowerPlants');
            });
        }
    }
    
    changehydroPlantStorageTypeHandler= (event) => {
        this.setState({hydroPlantStorageType: event.target.value});
    }

    cancel(){
        this.props.history.push('/hydroPowerPlants');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add HydroPowerPlant</h3>
        }else{
            return <h3 className="text-center">Update HydroPowerPlant</h3>
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
                                            <label> hydroPlantStorageType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateHydroPowerPlant}>Save</button>
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

export default CreateHydroPowerPlantComponent
