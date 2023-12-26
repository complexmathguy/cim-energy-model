import React, { Component } from 'react'
import DCTerminalService from '../services/DCTerminalService';

class CreateDCTerminalComponent extends Component {
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
            DCTerminalService.getDCTerminalById(this.state.id).then( (res) =>{
                let dCTerminal = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCTerminal = (e) => {
        e.preventDefault();
        let dCTerminal = {
                dCTerminalId: this.state.id,
            };
        console.log('dCTerminal => ' + JSON.stringify(dCTerminal));

        // step 5
        if(this.state.id === '_add'){
            dCTerminal.dCTerminalId=''
            DCTerminalService.createDCTerminal(dCTerminal).then(res =>{
                this.props.history.push('/dCTerminals');
            });
        }else{
            DCTerminalService.updateDCTerminal(dCTerminal).then( res => {
                this.props.history.push('/dCTerminals');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCTerminals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCTerminal</h3>
        }else{
            return <h3 className="text-center">Update DCTerminal</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCTerminal}>Save</button>
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

export default CreateDCTerminalComponent
