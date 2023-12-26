import React, { Component } from 'react'
import RegulatingControlService from '../services/RegulatingControlService';

class CreateRegulatingControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                mode: ''
        }
        this.changemodeHandler = this.changemodeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RegulatingControlService.getRegulatingControlById(this.state.id).then( (res) =>{
                let regulatingControl = res.data;
                this.setState({
                    mode: regulatingControl.mode
                });
            });
        }        
    }
    saveOrUpdateRegulatingControl = (e) => {
        e.preventDefault();
        let regulatingControl = {
                regulatingControlId: this.state.id,
                mode: this.state.mode
            };
        console.log('regulatingControl => ' + JSON.stringify(regulatingControl));

        // step 5
        if(this.state.id === '_add'){
            regulatingControl.regulatingControlId=''
            RegulatingControlService.createRegulatingControl(regulatingControl).then(res =>{
                this.props.history.push('/regulatingControls');
            });
        }else{
            RegulatingControlService.updateRegulatingControl(regulatingControl).then( res => {
                this.props.history.push('/regulatingControls');
            });
        }
    }
    
    changemodeHandler= (event) => {
        this.setState({mode: event.target.value});
    }

    cancel(){
        this.props.history.push('/regulatingControls');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RegulatingControl</h3>
        }else{
            return <h3 className="text-center">Update RegulatingControl</h3>
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
                                            <label> mode: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRegulatingControl}>Save</button>
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

export default CreateRegulatingControlComponent
