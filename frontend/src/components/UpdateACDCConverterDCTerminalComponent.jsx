import React, { Component } from 'react'
import ACDCConverterDCTerminalService from '../services/ACDCConverterDCTerminalService';

class UpdateACDCConverterDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                polarity: ''
        }
        this.updateACDCConverterDCTerminal = this.updateACDCConverterDCTerminal.bind(this);

        this.changepolarityHandler = this.changepolarityHandler.bind(this);
    }

    componentDidMount(){
        ACDCConverterDCTerminalService.getACDCConverterDCTerminalById(this.state.id).then( (res) =>{
            let aCDCConverterDCTerminal = res.data;
            this.setState({
                polarity: aCDCConverterDCTerminal.polarity
            });
        });
    }

    updateACDCConverterDCTerminal = (e) => {
        e.preventDefault();
        let aCDCConverterDCTerminal = {
            aCDCConverterDCTerminalId: this.state.id,
            polarity: this.state.polarity
        };
        console.log('aCDCConverterDCTerminal => ' + JSON.stringify(aCDCConverterDCTerminal));
        console.log('id => ' + JSON.stringify(this.state.id));
        ACDCConverterDCTerminalService.updateACDCConverterDCTerminal(aCDCConverterDCTerminal).then( res => {
            this.props.history.push('/aCDCConverterDCTerminals');
        });
    }

    changepolarityHandler= (event) => {
        this.setState({polarity: event.target.value});
    }

    cancel(){
        this.props.history.push('/aCDCConverterDCTerminals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ACDCConverterDCTerminal</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> polarity: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateACDCConverterDCTerminal}>Save</button>
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

export default UpdateACDCConverterDCTerminalComponent
