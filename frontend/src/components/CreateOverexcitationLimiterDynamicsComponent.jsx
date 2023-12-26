import React, { Component } from 'react'
import OverexcitationLimiterDynamicsService from '../services/OverexcitationLimiterDynamicsService';

class CreateOverexcitationLimiterDynamicsComponent extends Component {
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
            OverexcitationLimiterDynamicsService.getOverexcitationLimiterDynamicsById(this.state.id).then( (res) =>{
                let overexcitationLimiterDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOverexcitationLimiterDynamics = (e) => {
        e.preventDefault();
        let overexcitationLimiterDynamics = {
                overexcitationLimiterDynamicsId: this.state.id,
            };
        console.log('overexcitationLimiterDynamics => ' + JSON.stringify(overexcitationLimiterDynamics));

        // step 5
        if(this.state.id === '_add'){
            overexcitationLimiterDynamics.overexcitationLimiterDynamicsId=''
            OverexcitationLimiterDynamicsService.createOverexcitationLimiterDynamics(overexcitationLimiterDynamics).then(res =>{
                this.props.history.push('/overexcitationLimiterDynamicss');
            });
        }else{
            OverexcitationLimiterDynamicsService.updateOverexcitationLimiterDynamics(overexcitationLimiterDynamics).then( res => {
                this.props.history.push('/overexcitationLimiterDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/overexcitationLimiterDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcitationLimiterDynamics</h3>
        }else{
            return <h3 className="text-center">Update OverexcitationLimiterDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcitationLimiterDynamics}>Save</button>
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

export default CreateOverexcitationLimiterDynamicsComponent
