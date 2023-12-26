import React, { Component } from 'react'
import PFVArControllerType2DynamicsService from '../services/PFVArControllerType2DynamicsService';

class CreatePFVArControllerType2DynamicsComponent extends Component {
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
            PFVArControllerType2DynamicsService.getPFVArControllerType2DynamicsById(this.state.id).then( (res) =>{
                let pFVArControllerType2Dynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArControllerType2Dynamics = (e) => {
        e.preventDefault();
        let pFVArControllerType2Dynamics = {
                pFVArControllerType2DynamicsId: this.state.id,
            };
        console.log('pFVArControllerType2Dynamics => ' + JSON.stringify(pFVArControllerType2Dynamics));

        // step 5
        if(this.state.id === '_add'){
            pFVArControllerType2Dynamics.pFVArControllerType2DynamicsId=''
            PFVArControllerType2DynamicsService.createPFVArControllerType2Dynamics(pFVArControllerType2Dynamics).then(res =>{
                this.props.history.push('/pFVArControllerType2Dynamicss');
            });
        }else{
            PFVArControllerType2DynamicsService.updatePFVArControllerType2Dynamics(pFVArControllerType2Dynamics).then( res => {
                this.props.history.push('/pFVArControllerType2Dynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArControllerType2Dynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArControllerType2Dynamics</h3>
        }else{
            return <h3 className="text-center">Update PFVArControllerType2Dynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArControllerType2Dynamics}>Save</button>
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

export default CreatePFVArControllerType2DynamicsComponent
