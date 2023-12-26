import React, { Component } from 'react'
import EnergySchedulingTypeService from '../services/EnergySchedulingTypeService';

class CreateEnergySchedulingTypeComponent extends Component {
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
            EnergySchedulingTypeService.getEnergySchedulingTypeById(this.state.id).then( (res) =>{
                let energySchedulingType = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEnergySchedulingType = (e) => {
        e.preventDefault();
        let energySchedulingType = {
                energySchedulingTypeId: this.state.id,
            };
        console.log('energySchedulingType => ' + JSON.stringify(energySchedulingType));

        // step 5
        if(this.state.id === '_add'){
            energySchedulingType.energySchedulingTypeId=''
            EnergySchedulingTypeService.createEnergySchedulingType(energySchedulingType).then(res =>{
                this.props.history.push('/energySchedulingTypes');
            });
        }else{
            EnergySchedulingTypeService.updateEnergySchedulingType(energySchedulingType).then( res => {
                this.props.history.push('/energySchedulingTypes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/energySchedulingTypes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EnergySchedulingType</h3>
        }else{
            return <h3 className="text-center">Update EnergySchedulingType</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEnergySchedulingType}>Save</button>
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

export default CreateEnergySchedulingTypeComponent
