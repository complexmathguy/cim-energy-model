import React, { Component } from 'react'
import PssELIN2Service from '../services/PssELIN2Service'

class ViewPssELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssELIN2: {}
        }
    }

    componentDidMount(){
        PssELIN2Service.getPssELIN2ById(this.state.id).then( res => {
            this.setState({pssELIN2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssELIN2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> apss:&emsp; </label>
                            <div> { this.state.pssELIN2.apss }</div>
                        </div>
                        <div className = "row">
                            <label> ks1:&emsp; </label>
                            <div> { this.state.pssELIN2.ks1 }</div>
                        </div>
                        <div className = "row">
                            <label> ks2:&emsp; </label>
                            <div> { this.state.pssELIN2.ks2 }</div>
                        </div>
                        <div className = "row">
                            <label> ppss:&emsp; </label>
                            <div> { this.state.pssELIN2.ppss }</div>
                        </div>
                        <div className = "row">
                            <label> psslim:&emsp; </label>
                            <div> { this.state.pssELIN2.psslim }</div>
                        </div>
                        <div className = "row">
                            <label> ts1:&emsp; </label>
                            <div> { this.state.pssELIN2.ts1 }</div>
                        </div>
                        <div className = "row">
                            <label> ts2:&emsp; </label>
                            <div> { this.state.pssELIN2.ts2 }</div>
                        </div>
                        <div className = "row">
                            <label> ts3:&emsp; </label>
                            <div> { this.state.pssELIN2.ts3 }</div>
                        </div>
                        <div className = "row">
                            <label> ts4:&emsp; </label>
                            <div> { this.state.pssELIN2.ts4 }</div>
                        </div>
                        <div className = "row">
                            <label> ts5:&emsp; </label>
                            <div> { this.state.pssELIN2.ts5 }</div>
                        </div>
                        <div className = "row">
                            <label> ts6:&emsp; </label>
                            <div> { this.state.pssELIN2.ts6 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssELIN2Component
