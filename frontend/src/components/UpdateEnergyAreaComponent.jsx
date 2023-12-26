import React, { Component } from 'react'
import EnergyAreaService from '../services/EnergyAreaService';

class UpdateEnergyAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEnergyArea = this.updateEnergyArea.bind(this);

    }

    componentDidMount(){
        EnergyAreaService.getEnergyAreaById(this.state.id).then( (res) =>{
            let energyArea = res.data;
            this.setState({
            });
        });
    }

    updateEnergyArea = (e) => {
        e.preventDefault();
        let energyArea = {
            energyAreaId: this.state.id,
        };
        console.log('energyArea => ' + JSON.stringify(energyArea));
        console.log('id => ' + JSON.stringify(this.state.id));
        EnergyAreaService.updateEnergyArea(energyArea).then( res => {
            this.props.history.push('/energyAreas');
        });
    }


    cancel(){
        this.props.history.push('/energyAreas');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EnergyArea</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEnergyArea}>Save</button>
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

export default UpdateEnergyAreaComponent
