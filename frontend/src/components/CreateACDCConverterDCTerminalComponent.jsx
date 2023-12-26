import React, { Component } from 'react'
import ACDCConverterDCTerminalService from '../services/ACDCConverterDCTerminalService';

class CreateACDCConverterDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                polarity: ''
        }
        this.changepolarityHandler = this.changepolarityHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ACDCConverterDCTerminalService.getACDCConverterDCTerminalById(this.state.id).then( (res) =>{
                let aCDCConverterDCTerminal = res.data;
                this.setState({
                    polarity: aCDCConverterDCTerminal.polarity
                });
            });
        }        
    }
    saveOrUpdateACDCConverterDCTerminal = (e) => {
        e.preventDefault();
        let aCDCConverterDCTerminal = {
                aCDCConverterDCTerminalId: this.state.id,
                polarity: this.state.polarity
            };
        console.log('aCDCConverterDCTerminal => ' + JSON.stringify(aCDCConverterDCTerminal));

        // step 5
        if(this.state.id === '_add'){
            aCDCConverterDCTerminal.aCDCConverterDCTerminalId=''
            ACDCConverterDCTerminalService.createACDCConverterDCTerminal(aCDCConverterDCTerminal).then(res =>{
                this.props.history.push('/aCDCConverterDCTerminals');
            });
        }else{
            ACDCConverterDCTerminalService.updateACDCConverterDCTerminal(aCDCConverterDCTerminal).then( res => {
                this.props.history.push('/aCDCConverterDCTerminals');
            });
        }
    }
    
    changepolarityHandler= (event) => {
        this.setState({polarity: event.target.value});
    }

    cancel(){
        this.props.history.push('/aCDCConverterDCTerminals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ACDCConverterDCTerminal</h3>
        }else{
            return <h3 className="text-center">Update ACDCConverterDCTerminal</h3>
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
                                            <label> polarity: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateACDCConverterDCTerminal}>Save</button>
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

export default CreateACDCConverterDCTerminalComponent
