import React, { Component } from 'react'
import DiscontinuousExcitationControlDynamicsService from '../services/DiscontinuousExcitationControlDynamicsService';

class CreateDiscontinuousExcitationControlDynamicsComponent extends Component {
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
            DiscontinuousExcitationControlDynamicsService.getDiscontinuousExcitationControlDynamicsById(this.state.id).then( (res) =>{
                let discontinuousExcitationControlDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiscontinuousExcitationControlDynamics = (e) => {
        e.preventDefault();
        let discontinuousExcitationControlDynamics = {
                discontinuousExcitationControlDynamicsId: this.state.id,
            };
        console.log('discontinuousExcitationControlDynamics => ' + JSON.stringify(discontinuousExcitationControlDynamics));

        // step 5
        if(this.state.id === '_add'){
            discontinuousExcitationControlDynamics.discontinuousExcitationControlDynamicsId=''
            DiscontinuousExcitationControlDynamicsService.createDiscontinuousExcitationControlDynamics(discontinuousExcitationControlDynamics).then(res =>{
                this.props.history.push('/discontinuousExcitationControlDynamicss');
            });
        }else{
            DiscontinuousExcitationControlDynamicsService.updateDiscontinuousExcitationControlDynamics(discontinuousExcitationControlDynamics).then( res => {
                this.props.history.push('/discontinuousExcitationControlDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/discontinuousExcitationControlDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiscontinuousExcitationControlDynamics</h3>
        }else{
            return <h3 className="text-center">Update DiscontinuousExcitationControlDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscontinuousExcitationControlDynamics}>Save</button>
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

export default CreateDiscontinuousExcitationControlDynamicsComponent
