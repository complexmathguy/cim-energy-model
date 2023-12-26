import React, { Component } from 'react'
import SolarGeneratingUnitService from '../services/SolarGeneratingUnitService';

class CreateSolarGeneratingUnitComponent extends Component {
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
            SolarGeneratingUnitService.getSolarGeneratingUnitById(this.state.id).then( (res) =>{
                let solarGeneratingUnit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSolarGeneratingUnit = (e) => {
        e.preventDefault();
        let solarGeneratingUnit = {
                solarGeneratingUnitId: this.state.id,
            };
        console.log('solarGeneratingUnit => ' + JSON.stringify(solarGeneratingUnit));

        // step 5
        if(this.state.id === '_add'){
            solarGeneratingUnit.solarGeneratingUnitId=''
            SolarGeneratingUnitService.createSolarGeneratingUnit(solarGeneratingUnit).then(res =>{
                this.props.history.push('/solarGeneratingUnits');
            });
        }else{
            SolarGeneratingUnitService.updateSolarGeneratingUnit(solarGeneratingUnit).then( res => {
                this.props.history.push('/solarGeneratingUnits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/solarGeneratingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SolarGeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update SolarGeneratingUnit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSolarGeneratingUnit}>Save</button>
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

export default CreateSolarGeneratingUnitComponent
