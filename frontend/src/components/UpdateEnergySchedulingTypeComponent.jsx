import React, { Component } from 'react'
import EnergySchedulingTypeService from '../services/EnergySchedulingTypeService';

class UpdateEnergySchedulingTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEnergySchedulingType = this.updateEnergySchedulingType.bind(this);

    }

    componentDidMount(){
        EnergySchedulingTypeService.getEnergySchedulingTypeById(this.state.id).then( (res) =>{
            let energySchedulingType = res.data;
            this.setState({
            });
        });
    }

    updateEnergySchedulingType = (e) => {
        e.preventDefault();
        let energySchedulingType = {
            energySchedulingTypeId: this.state.id,
        };
        console.log('energySchedulingType => ' + JSON.stringify(energySchedulingType));
        console.log('id => ' + JSON.stringify(this.state.id));
        EnergySchedulingTypeService.updateEnergySchedulingType(energySchedulingType).then( res => {
            this.props.history.push('/energySchedulingTypes');
        });
    }


    cancel(){
        this.props.history.push('/energySchedulingTypes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EnergySchedulingType</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEnergySchedulingType}>Save</button>
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

export default UpdateEnergySchedulingTypeComponent
