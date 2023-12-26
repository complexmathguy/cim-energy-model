import React, { Component } from 'react'
import TerminalService from '../services/TerminalService';

class CreateTerminalComponent extends Component {
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
            TerminalService.getTerminalById(this.state.id).then( (res) =>{
                let terminal = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTerminal = (e) => {
        e.preventDefault();
        let terminal = {
                terminalId: this.state.id,
            };
        console.log('terminal => ' + JSON.stringify(terminal));

        // step 5
        if(this.state.id === '_add'){
            terminal.terminalId=''
            TerminalService.createTerminal(terminal).then(res =>{
                this.props.history.push('/terminals');
            });
        }else{
            TerminalService.updateTerminal(terminal).then( res => {
                this.props.history.push('/terminals');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/terminals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Terminal</h3>
        }else{
            return <h3 className="text-center">Update Terminal</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTerminal}>Save</button>
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

export default CreateTerminalComponent
