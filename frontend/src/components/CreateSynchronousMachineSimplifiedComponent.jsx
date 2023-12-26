import React, { Component } from 'react'
import SynchronousMachineSimplifiedService from '../services/SynchronousMachineSimplifiedService';

class CreateSynchronousMachineSimplifiedComponent extends Component {
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
            SynchronousMachineSimplifiedService.getSynchronousMachineSimplifiedById(this.state.id).then( (res) =>{
                let synchronousMachineSimplified = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachineSimplified = (e) => {
        e.preventDefault();
        let synchronousMachineSimplified = {
                synchronousMachineSimplifiedId: this.state.id,
            };
        console.log('synchronousMachineSimplified => ' + JSON.stringify(synchronousMachineSimplified));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineSimplified.synchronousMachineSimplifiedId=''
            SynchronousMachineSimplifiedService.createSynchronousMachineSimplified(synchronousMachineSimplified).then(res =>{
                this.props.history.push('/synchronousMachineSimplifieds');
            });
        }else{
            SynchronousMachineSimplifiedService.updateSynchronousMachineSimplified(synchronousMachineSimplified).then( res => {
                this.props.history.push('/synchronousMachineSimplifieds');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/synchronousMachineSimplifieds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineSimplified</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineSimplified</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineSimplified}>Save</button>
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

export default CreateSynchronousMachineSimplifiedComponent
