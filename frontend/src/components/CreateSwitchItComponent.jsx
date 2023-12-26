import React, { Component } from 'react'
import SwitchItService from '../services/SwitchItService';

class CreateSwitchItComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                open: ''
        }
        this.changeopenHandler = this.changeopenHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SwitchItService.getSwitchItById(this.state.id).then( (res) =>{
                let switchIt = res.data;
                this.setState({
                    open: switchIt.open
                });
            });
        }        
    }
    saveOrUpdateSwitchIt = (e) => {
        e.preventDefault();
        let switchIt = {
                switchItId: this.state.id,
                open: this.state.open
            };
        console.log('switchIt => ' + JSON.stringify(switchIt));

        // step 5
        if(this.state.id === '_add'){
            switchIt.switchItId=''
            SwitchItService.createSwitchIt(switchIt).then(res =>{
                this.props.history.push('/switchIts');
            });
        }else{
            SwitchItService.updateSwitchIt(switchIt).then( res => {
                this.props.history.push('/switchIts');
            });
        }
    }
    
    changeopenHandler= (event) => {
        this.setState({open: event.target.value});
    }

    cancel(){
        this.props.history.push('/switchIts');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SwitchIt</h3>
        }else{
            return <h3 className="text-center">Update SwitchIt</h3>
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
                                            <label> open: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSwitchIt}>Save</button>
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

export default CreateSwitchItComponent
