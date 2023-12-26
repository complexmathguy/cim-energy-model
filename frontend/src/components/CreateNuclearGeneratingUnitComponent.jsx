import React, { Component } from 'react'
import NuclearGeneratingUnitService from '../services/NuclearGeneratingUnitService';

class CreateNuclearGeneratingUnitComponent extends Component {
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
            NuclearGeneratingUnitService.getNuclearGeneratingUnitById(this.state.id).then( (res) =>{
                let nuclearGeneratingUnit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateNuclearGeneratingUnit = (e) => {
        e.preventDefault();
        let nuclearGeneratingUnit = {
                nuclearGeneratingUnitId: this.state.id,
            };
        console.log('nuclearGeneratingUnit => ' + JSON.stringify(nuclearGeneratingUnit));

        // step 5
        if(this.state.id === '_add'){
            nuclearGeneratingUnit.nuclearGeneratingUnitId=''
            NuclearGeneratingUnitService.createNuclearGeneratingUnit(nuclearGeneratingUnit).then(res =>{
                this.props.history.push('/nuclearGeneratingUnits');
            });
        }else{
            NuclearGeneratingUnitService.updateNuclearGeneratingUnit(nuclearGeneratingUnit).then( res => {
                this.props.history.push('/nuclearGeneratingUnits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/nuclearGeneratingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NuclearGeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update NuclearGeneratingUnit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNuclearGeneratingUnit}>Save</button>
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

export default CreateNuclearGeneratingUnitComponent
