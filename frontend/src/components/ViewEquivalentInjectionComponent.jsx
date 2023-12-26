import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService'

class ViewEquivalentInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentInjection: {}
        }
    }

    componentDidMount(){
        EquivalentInjectionService.getEquivalentInjectionById(this.state.id).then( res => {
            this.setState({equivalentInjection: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentInjection Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> maxP:&emsp; </label>
                            <div> { this.state.equivalentInjection.maxP }</div>
                        </div>
                        <div className = "row">
                            <label> maxQ:&emsp; </label>
                            <div> { this.state.equivalentInjection.maxQ }</div>
                        </div>
                        <div className = "row">
                            <label> minP:&emsp; </label>
                            <div> { this.state.equivalentInjection.minP }</div>
                        </div>
                        <div className = "row">
                            <label> minQ:&emsp; </label>
                            <div> { this.state.equivalentInjection.minQ }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.equivalentInjection.r }</div>
                        </div>
                        <div className = "row">
                            <label> r0:&emsp; </label>
                            <div> { this.state.equivalentInjection.r0 }</div>
                        </div>
                        <div className = "row">
                            <label> r2:&emsp; </label>
                            <div> { this.state.equivalentInjection.r2 }</div>
                        </div>
                        <div className = "row">
                            <label> regulationCapability:&emsp; </label>
                            <div> { this.state.equivalentInjection.regulationCapability }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.equivalentInjection.x }</div>
                        </div>
                        <div className = "row">
                            <label> x0:&emsp; </label>
                            <div> { this.state.equivalentInjection.x0 }</div>
                        </div>
                        <div className = "row">
                            <label> x2:&emsp; </label>
                            <div> { this.state.equivalentInjection.x2 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentInjectionComponent
