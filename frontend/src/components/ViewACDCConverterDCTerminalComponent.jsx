import React, { Component } from 'react'
import ACDCConverterDCTerminalService from '../services/ACDCConverterDCTerminalService'

class ViewACDCConverterDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            aCDCConverterDCTerminal: {}
        }
    }

    componentDidMount(){
        ACDCConverterDCTerminalService.getACDCConverterDCTerminalById(this.state.id).then( res => {
            this.setState({aCDCConverterDCTerminal: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ACDCConverterDCTerminal Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> polarity:&emsp; </label>
                            <div> { this.state.aCDCConverterDCTerminal.polarity }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewACDCConverterDCTerminalComponent
