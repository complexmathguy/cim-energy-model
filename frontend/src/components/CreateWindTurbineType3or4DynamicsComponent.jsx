import React, { Component } from 'react'
import WindTurbineType3or4DynamicsService from '../services/WindTurbineType3or4DynamicsService';

class CreateWindTurbineType3or4DynamicsComponent extends Component {
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
            WindTurbineType3or4DynamicsService.getWindTurbineType3or4DynamicsById(this.state.id).then( (res) =>{
                let windTurbineType3or4Dynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindTurbineType3or4Dynamics = (e) => {
        e.preventDefault();
        let windTurbineType3or4Dynamics = {
                windTurbineType3or4DynamicsId: this.state.id,
            };
        console.log('windTurbineType3or4Dynamics => ' + JSON.stringify(windTurbineType3or4Dynamics));

        // step 5
        if(this.state.id === '_add'){
            windTurbineType3or4Dynamics.windTurbineType3or4DynamicsId=''
            WindTurbineType3or4DynamicsService.createWindTurbineType3or4Dynamics(windTurbineType3or4Dynamics).then(res =>{
                this.props.history.push('/windTurbineType3or4Dynamicss');
            });
        }else{
            WindTurbineType3or4DynamicsService.updateWindTurbineType3or4Dynamics(windTurbineType3or4Dynamics).then( res => {
                this.props.history.push('/windTurbineType3or4Dynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windTurbineType3or4Dynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindTurbineType3or4Dynamics</h3>
        }else{
            return <h3 className="text-center">Update WindTurbineType3or4Dynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindTurbineType3or4Dynamics}>Save</button>
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

export default CreateWindTurbineType3or4DynamicsComponent
