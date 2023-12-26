import React, { Component } from 'react'
import SvInjectionService from '../services/SvInjectionService'

class ViewSvInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svInjection: {}
        }
    }

    componentDidMount(){
        SvInjectionService.getSvInjectionById(this.state.id).then( res => {
            this.setState({svInjection: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvInjection Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> pInjection:&emsp; </label>
                            <div> { this.state.svInjection.pInjection }</div>
                        </div>
                        <div className = "row">
                            <label> qInjection:&emsp; </label>
                            <div> { this.state.svInjection.qInjection }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvInjectionComponent
