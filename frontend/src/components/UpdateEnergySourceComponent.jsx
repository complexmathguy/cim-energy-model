import React, { Component } from 'react'
import EnergySourceService from '../services/EnergySourceService';

class UpdateEnergySourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEnergySource = this.updateEnergySource.bind(this);

    }

    componentDidMount(){
        EnergySourceService.getEnergySourceById(this.state.id).then( (res) =>{
            let energySource = res.data;
            this.setState({
            });
        });
    }

    updateEnergySource = (e) => {
        e.preventDefault();
        let energySource = {
            energySourceId: this.state.id,
        };
        console.log('energySource => ' + JSON.stringify(energySource));
        console.log('id => ' + JSON.stringify(this.state.id));
        EnergySourceService.updateEnergySource(energySource).then( res => {
            this.props.history.push('/energySources');
        });
    }


    cancel(){
        this.props.history.push('/energySources');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EnergySource</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEnergySource}>Save</button>
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

export default UpdateEnergySourceComponent
