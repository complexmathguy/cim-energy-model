import React, { Component } from 'react'
import WindDynamicsLookupTableService from '../services/WindDynamicsLookupTableService'

class ViewWindDynamicsLookupTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windDynamicsLookupTable: {}
        }
    }

    componentDidMount(){
        WindDynamicsLookupTableService.getWindDynamicsLookupTableById(this.state.id).then( res => {
            this.setState({windDynamicsLookupTable: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindDynamicsLookupTable Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> input:&emsp; </label>
                            <div> { this.state.windDynamicsLookupTable.input }</div>
                        </div>
                        <div className = "row">
                            <label> lookupTableFunctionType:&emsp; </label>
                            <div> { this.state.windDynamicsLookupTable.lookupTableFunctionType }</div>
                        </div>
                        <div className = "row">
                            <label> output:&emsp; </label>
                            <div> { this.state.windDynamicsLookupTable.output }</div>
                        </div>
                        <div className = "row">
                            <label> sequence:&emsp; </label>
                            <div> { this.state.windDynamicsLookupTable.sequence }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindDynamicsLookupTableComponent
