import React, { Component } from 'react'
import SubstationService from '../services/SubstationService';

class CreateSubstationComponent extends Component {
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
            SubstationService.getSubstationById(this.state.id).then( (res) =>{
                let substation = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSubstation = (e) => {
        e.preventDefault();
        let substation = {
                substationId: this.state.id,
            };
        console.log('substation => ' + JSON.stringify(substation));

        // step 5
        if(this.state.id === '_add'){
            substation.substationId=''
            SubstationService.createSubstation(substation).then(res =>{
                this.props.history.push('/substations');
            });
        }else{
            SubstationService.updateSubstation(substation).then( res => {
                this.props.history.push('/substations');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/substations');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Substation</h3>
        }else{
            return <h3 className="text-center">Update Substation</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSubstation}>Save</button>
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

export default CreateSubstationComponent
