import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService'

class ViewEquivalentBranchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentBranch: {}
        }
    }

    componentDidMount(){
        EquivalentBranchService.getEquivalentBranchById(this.state.id).then( res => {
            this.setState({equivalentBranch: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentBranch Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> negativeR12:&emsp; </label>
                            <div> { this.state.equivalentBranch.negativeR12 }</div>
                        </div>
                        <div className = "row">
                            <label> negativeR21:&emsp; </label>
                            <div> { this.state.equivalentBranch.negativeR21 }</div>
                        </div>
                        <div className = "row">
                            <label> negativeX12:&emsp; </label>
                            <div> { this.state.equivalentBranch.negativeX12 }</div>
                        </div>
                        <div className = "row">
                            <label> negativeX21:&emsp; </label>
                            <div> { this.state.equivalentBranch.negativeX21 }</div>
                        </div>
                        <div className = "row">
                            <label> positiveR12:&emsp; </label>
                            <div> { this.state.equivalentBranch.positiveR12 }</div>
                        </div>
                        <div className = "row">
                            <label> positiveR21:&emsp; </label>
                            <div> { this.state.equivalentBranch.positiveR21 }</div>
                        </div>
                        <div className = "row">
                            <label> positiveX12:&emsp; </label>
                            <div> { this.state.equivalentBranch.positiveX12 }</div>
                        </div>
                        <div className = "row">
                            <label> positiveX21:&emsp; </label>
                            <div> { this.state.equivalentBranch.positiveX21 }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.equivalentBranch.r }</div>
                        </div>
                        <div className = "row">
                            <label> r21:&emsp; </label>
                            <div> { this.state.equivalentBranch.r21 }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.equivalentBranch.x }</div>
                        </div>
                        <div className = "row">
                            <label> x21:&emsp; </label>
                            <div> { this.state.equivalentBranch.x21 }</div>
                        </div>
                        <div className = "row">
                            <label> zeroR12:&emsp; </label>
                            <div> { this.state.equivalentBranch.zeroR12 }</div>
                        </div>
                        <div className = "row">
                            <label> zeroR21:&emsp; </label>
                            <div> { this.state.equivalentBranch.zeroR21 }</div>
                        </div>
                        <div className = "row">
                            <label> zeroX12:&emsp; </label>
                            <div> { this.state.equivalentBranch.zeroX12 }</div>
                        </div>
                        <div className = "row">
                            <label> zeroX21:&emsp; </label>
                            <div> { this.state.equivalentBranch.zeroX21 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentBranchComponent
