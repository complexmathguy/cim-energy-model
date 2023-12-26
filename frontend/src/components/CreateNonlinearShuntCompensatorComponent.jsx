import React, { Component } from 'react'
import NonlinearShuntCompensatorService from '../services/NonlinearShuntCompensatorService';

class CreateNonlinearShuntCompensatorComponent extends Component {
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
            NonlinearShuntCompensatorService.getNonlinearShuntCompensatorById(this.state.id).then( (res) =>{
                let nonlinearShuntCompensator = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateNonlinearShuntCompensator = (e) => {
        e.preventDefault();
        let nonlinearShuntCompensator = {
                nonlinearShuntCompensatorId: this.state.id,
            };
        console.log('nonlinearShuntCompensator => ' + JSON.stringify(nonlinearShuntCompensator));

        // step 5
        if(this.state.id === '_add'){
            nonlinearShuntCompensator.nonlinearShuntCompensatorId=''
            NonlinearShuntCompensatorService.createNonlinearShuntCompensator(nonlinearShuntCompensator).then(res =>{
                this.props.history.push('/nonlinearShuntCompensators');
            });
        }else{
            NonlinearShuntCompensatorService.updateNonlinearShuntCompensator(nonlinearShuntCompensator).then( res => {
                this.props.history.push('/nonlinearShuntCompensators');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/nonlinearShuntCompensators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NonlinearShuntCompensator</h3>
        }else{
            return <h3 className="text-center">Update NonlinearShuntCompensator</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNonlinearShuntCompensator}>Save</button>
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

export default CreateNonlinearShuntCompensatorComponent
