import React, { Component } from 'react'
import HydroPowerPlantService from '../services/HydroPowerPlantService';

class UpdateHydroPowerPlantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                hydroPlantStorageType: ''
        }
        this.updateHydroPowerPlant = this.updateHydroPowerPlant.bind(this);

        this.changehydroPlantStorageTypeHandler = this.changehydroPlantStorageTypeHandler.bind(this);
    }

    componentDidMount(){
        HydroPowerPlantService.getHydroPowerPlantById(this.state.id).then( (res) =>{
            let hydroPowerPlant = res.data;
            this.setState({
                hydroPlantStorageType: hydroPowerPlant.hydroPlantStorageType
            });
        });
    }

    updateHydroPowerPlant = (e) => {
        e.preventDefault();
        let hydroPowerPlant = {
            hydroPowerPlantId: this.state.id,
            hydroPlantStorageType: this.state.hydroPlantStorageType
        };
        console.log('hydroPowerPlant => ' + JSON.stringify(hydroPowerPlant));
        console.log('id => ' + JSON.stringify(this.state.id));
        HydroPowerPlantService.updateHydroPowerPlant(hydroPowerPlant).then( res => {
            this.props.history.push('/hydroPowerPlants');
        });
    }

    changehydroPlantStorageTypeHandler= (event) => {
        this.setState({hydroPlantStorageType: event.target.value});
    }

    cancel(){
        this.props.history.push('/hydroPowerPlants');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update HydroPowerPlant</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> hydroPlantStorageType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateHydroPowerPlant}>Save</button>
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

export default UpdateHydroPowerPlantComponent
