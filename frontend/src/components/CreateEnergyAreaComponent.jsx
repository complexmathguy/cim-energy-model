import React, { Component } from 'react'
import EnergyAreaService from '../services/EnergyAreaService';

class CreateEnergyAreaComponent extends Component {
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
            EnergyAreaService.getEnergyAreaById(this.state.id).then( (res) =>{
                let energyArea = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEnergyArea = (e) => {
        e.preventDefault();
        let energyArea = {
                energyAreaId: this.state.id,
            };
        console.log('energyArea => ' + JSON.stringify(energyArea));

        // step 5
        if(this.state.id === '_add'){
            energyArea.energyAreaId=''
            EnergyAreaService.createEnergyArea(energyArea).then(res =>{
                this.props.history.push('/energyAreas');
            });
        }else{
            EnergyAreaService.updateEnergyArea(energyArea).then( res => {
                this.props.history.push('/energyAreas');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/energyAreas');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EnergyArea</h3>
        }else{
            return <h3 className="text-center">Update EnergyArea</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEnergyArea}>Save</button>
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

export default CreateEnergyAreaComponent
