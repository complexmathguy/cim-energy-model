import React, { Component } from 'react'
import CommandService from '../services/CommandService';

class CreateCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                normalValue: '',
                value: ''
        }
        this.changenormalValueHandler = this.changenormalValueHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CommandService.getCommandById(this.state.id).then( (res) =>{
                let command = res.data;
                this.setState({
                    normalValue: command.normalValue,
                    value: command.value
                });
            });
        }        
    }
    saveOrUpdateCommand = (e) => {
        e.preventDefault();
        let command = {
                commandId: this.state.id,
                normalValue: this.state.normalValue,
                value: this.state.value
            };
        console.log('command => ' + JSON.stringify(command));

        // step 5
        if(this.state.id === '_add'){
            command.commandId=''
            CommandService.createCommand(command).then(res =>{
                this.props.history.push('/commands');
            });
        }else{
            CommandService.updateCommand(command).then( res => {
                this.props.history.push('/commands');
            });
        }
    }
    
    changenormalValueHandler= (event) => {
        this.setState({normalValue: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/commands');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Command</h3>
        }else{
            return <h3 className="text-center">Update Command</h3>
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
                                            <label> normalValue: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCommand}>Save</button>
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

export default CreateCommandComponent
