import React, { Component } from 'react'
import EnergySourceService from '../services/EnergySourceService';

class CreateEnergySourceComponent extends Component {
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
            EnergySourceService.getEnergySourceById(this.state.id).then( (res) =>{
                let energySource = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEnergySource = (e) => {
        e.preventDefault();
        let energySource = {
                energySourceId: this.state.id,
            };
        console.log('energySource => ' + JSON.stringify(energySource));

        // step 5
        if(this.state.id === '_add'){
            energySource.energySourceId=''
            EnergySourceService.createEnergySource(energySource).then(res =>{
                this.props.history.push('/energySources');
            });
        }else{
            EnergySourceService.updateEnergySource(energySource).then( res => {
                this.props.history.push('/energySources');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/energySources');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EnergySource</h3>
        }else{
            return <h3 className="text-center">Update EnergySource</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEnergySource}>Save</button>
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

export default CreateEnergySourceComponent
