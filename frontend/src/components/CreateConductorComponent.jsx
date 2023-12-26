import React, { Component } from 'react'
import ConductorService from '../services/ConductorService';

class CreateConductorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                length: ''
        }
        this.changelengthHandler = this.changelengthHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ConductorService.getConductorById(this.state.id).then( (res) =>{
                let conductor = res.data;
                this.setState({
                    length: conductor.length
                });
            });
        }        
    }
    saveOrUpdateConductor = (e) => {
        e.preventDefault();
        let conductor = {
                conductorId: this.state.id,
                length: this.state.length
            };
        console.log('conductor => ' + JSON.stringify(conductor));

        // step 5
        if(this.state.id === '_add'){
            conductor.conductorId=''
            ConductorService.createConductor(conductor).then(res =>{
                this.props.history.push('/conductors');
            });
        }else{
            ConductorService.updateConductor(conductor).then( res => {
                this.props.history.push('/conductors');
            });
        }
    }
    
    changelengthHandler= (event) => {
        this.setState({length: event.target.value});
    }

    cancel(){
        this.props.history.push('/conductors');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Conductor</h3>
        }else{
            return <h3 className="text-center">Update Conductor</h3>
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
                                            <label> length: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConductor}>Save</button>
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

export default CreateConductorComponent
