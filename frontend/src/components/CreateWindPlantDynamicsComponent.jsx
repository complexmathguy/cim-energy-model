import React, { Component } from 'react'
import WindPlantDynamicsService from '../services/WindPlantDynamicsService';

class CreateWindPlantDynamicsComponent extends Component {
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
            WindPlantDynamicsService.getWindPlantDynamicsById(this.state.id).then( (res) =>{
                let windPlantDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindPlantDynamics = (e) => {
        e.preventDefault();
        let windPlantDynamics = {
                windPlantDynamicsId: this.state.id,
            };
        console.log('windPlantDynamics => ' + JSON.stringify(windPlantDynamics));

        // step 5
        if(this.state.id === '_add'){
            windPlantDynamics.windPlantDynamicsId=''
            WindPlantDynamicsService.createWindPlantDynamics(windPlantDynamics).then(res =>{
                this.props.history.push('/windPlantDynamicss');
            });
        }else{
            WindPlantDynamicsService.updateWindPlantDynamics(windPlantDynamics).then( res => {
                this.props.history.push('/windPlantDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windPlantDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPlantDynamics</h3>
        }else{
            return <h3 className="text-center">Update WindPlantDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPlantDynamics}>Save</button>
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

export default CreateWindPlantDynamicsComponent
