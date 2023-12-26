import React, { Component } from 'react'
import ACDCTerminalService from '../services/ACDCTerminalService';

class CreateACDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                sequenceNumber: ''
        }
        this.changesequenceNumberHandler = this.changesequenceNumberHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ACDCTerminalService.getACDCTerminalById(this.state.id).then( (res) =>{
                let aCDCTerminal = res.data;
                this.setState({
                    sequenceNumber: aCDCTerminal.sequenceNumber
                });
            });
        }        
    }
    saveOrUpdateACDCTerminal = (e) => {
        e.preventDefault();
        let aCDCTerminal = {
                aCDCTerminalId: this.state.id,
                sequenceNumber: this.state.sequenceNumber
            };
        console.log('aCDCTerminal => ' + JSON.stringify(aCDCTerminal));

        // step 5
        if(this.state.id === '_add'){
            aCDCTerminal.aCDCTerminalId=''
            ACDCTerminalService.createACDCTerminal(aCDCTerminal).then(res =>{
                this.props.history.push('/aCDCTerminals');
            });
        }else{
            ACDCTerminalService.updateACDCTerminal(aCDCTerminal).then( res => {
                this.props.history.push('/aCDCTerminals');
            });
        }
    }
    
    changesequenceNumberHandler= (event) => {
        this.setState({sequenceNumber: event.target.value});
    }

    cancel(){
        this.props.history.push('/aCDCTerminals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ACDCTerminal</h3>
        }else{
            return <h3 className="text-center">Update ACDCTerminal</h3>
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
                                            <label> sequenceNumber: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateACDCTerminal}>Save</button>
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

export default CreateACDCTerminalComponent
