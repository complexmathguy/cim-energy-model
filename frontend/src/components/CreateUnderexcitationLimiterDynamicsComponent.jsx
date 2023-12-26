import React, { Component } from 'react'
import UnderexcitationLimiterDynamicsService from '../services/UnderexcitationLimiterDynamicsService';

class CreateUnderexcitationLimiterDynamicsComponent extends Component {
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
            UnderexcitationLimiterDynamicsService.getUnderexcitationLimiterDynamicsById(this.state.id).then( (res) =>{
                let underexcitationLimiterDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnderexcitationLimiterDynamics = (e) => {
        e.preventDefault();
        let underexcitationLimiterDynamics = {
                underexcitationLimiterDynamicsId: this.state.id,
            };
        console.log('underexcitationLimiterDynamics => ' + JSON.stringify(underexcitationLimiterDynamics));

        // step 5
        if(this.state.id === '_add'){
            underexcitationLimiterDynamics.underexcitationLimiterDynamicsId=''
            UnderexcitationLimiterDynamicsService.createUnderexcitationLimiterDynamics(underexcitationLimiterDynamics).then(res =>{
                this.props.history.push('/underexcitationLimiterDynamicss');
            });
        }else{
            UnderexcitationLimiterDynamicsService.updateUnderexcitationLimiterDynamics(underexcitationLimiterDynamics).then( res => {
                this.props.history.push('/underexcitationLimiterDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/underexcitationLimiterDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcitationLimiterDynamics</h3>
        }else{
            return <h3 className="text-center">Update UnderexcitationLimiterDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcitationLimiterDynamics}>Save</button>
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

export default CreateUnderexcitationLimiterDynamicsComponent
