import React, { Component } from 'react'
import WindTurbineType1or2DynamicsService from '../services/WindTurbineType1or2DynamicsService';

class CreateWindTurbineType1or2DynamicsComponent extends Component {
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
            WindTurbineType1or2DynamicsService.getWindTurbineType1or2DynamicsById(this.state.id).then( (res) =>{
                let windTurbineType1or2Dynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindTurbineType1or2Dynamics = (e) => {
        e.preventDefault();
        let windTurbineType1or2Dynamics = {
                windTurbineType1or2DynamicsId: this.state.id,
            };
        console.log('windTurbineType1or2Dynamics => ' + JSON.stringify(windTurbineType1or2Dynamics));

        // step 5
        if(this.state.id === '_add'){
            windTurbineType1or2Dynamics.windTurbineType1or2DynamicsId=''
            WindTurbineType1or2DynamicsService.createWindTurbineType1or2Dynamics(windTurbineType1or2Dynamics).then(res =>{
                this.props.history.push('/windTurbineType1or2Dynamicss');
            });
        }else{
            WindTurbineType1or2DynamicsService.updateWindTurbineType1or2Dynamics(windTurbineType1or2Dynamics).then( res => {
                this.props.history.push('/windTurbineType1or2Dynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windTurbineType1or2Dynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindTurbineType1or2Dynamics</h3>
        }else{
            return <h3 className="text-center">Update WindTurbineType1or2Dynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindTurbineType1or2Dynamics}>Save</button>
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

export default CreateWindTurbineType1or2DynamicsComponent
