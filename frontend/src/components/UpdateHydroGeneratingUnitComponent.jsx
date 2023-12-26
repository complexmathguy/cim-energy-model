import React, { Component } from 'react'
import HydroGeneratingUnitService from '../services/HydroGeneratingUnitService';

class UpdateHydroGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                energyConversionCapability: ''
        }
        this.updateHydroGeneratingUnit = this.updateHydroGeneratingUnit.bind(this);

        this.changeenergyConversionCapabilityHandler = this.changeenergyConversionCapabilityHandler.bind(this);
    }

    componentDidMount(){
        HydroGeneratingUnitService.getHydroGeneratingUnitById(this.state.id).then( (res) =>{
            let hydroGeneratingUnit = res.data;
            this.setState({
                energyConversionCapability: hydroGeneratingUnit.energyConversionCapability
            });
        });
    }

    updateHydroGeneratingUnit = (e) => {
        e.preventDefault();
        let hydroGeneratingUnit = {
            hydroGeneratingUnitId: this.state.id,
            energyConversionCapability: this.state.energyConversionCapability
        };
        console.log('hydroGeneratingUnit => ' + JSON.stringify(hydroGeneratingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        HydroGeneratingUnitService.updateHydroGeneratingUnit(hydroGeneratingUnit).then( res => {
            this.props.history.push('/hydroGeneratingUnits');
        });
    }

    changeenergyConversionCapabilityHandler= (event) => {
        this.setState({energyConversionCapability: event.target.value});
    }

    cancel(){
        this.props.history.push('/hydroGeneratingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update HydroGeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> energyConversionCapability: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateHydroGeneratingUnit}>Save</button>
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

export default UpdateHydroGeneratingUnitComponent
