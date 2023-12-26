import React, { Component } from 'react'
import PFVArControllerType1DynamicsService from '../services/PFVArControllerType1DynamicsService';

class CreatePFVArControllerType1DynamicsComponent extends Component {
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
            PFVArControllerType1DynamicsService.getPFVArControllerType1DynamicsById(this.state.id).then( (res) =>{
                let pFVArControllerType1Dynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArControllerType1Dynamics = (e) => {
        e.preventDefault();
        let pFVArControllerType1Dynamics = {
                pFVArControllerType1DynamicsId: this.state.id,
            };
        console.log('pFVArControllerType1Dynamics => ' + JSON.stringify(pFVArControllerType1Dynamics));

        // step 5
        if(this.state.id === '_add'){
            pFVArControllerType1Dynamics.pFVArControllerType1DynamicsId=''
            PFVArControllerType1DynamicsService.createPFVArControllerType1Dynamics(pFVArControllerType1Dynamics).then(res =>{
                this.props.history.push('/pFVArControllerType1Dynamicss');
            });
        }else{
            PFVArControllerType1DynamicsService.updatePFVArControllerType1Dynamics(pFVArControllerType1Dynamics).then( res => {
                this.props.history.push('/pFVArControllerType1Dynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArControllerType1Dynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArControllerType1Dynamics</h3>
        }else{
            return <h3 className="text-center">Update PFVArControllerType1Dynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArControllerType1Dynamics}>Save</button>
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

export default CreatePFVArControllerType1DynamicsComponent
