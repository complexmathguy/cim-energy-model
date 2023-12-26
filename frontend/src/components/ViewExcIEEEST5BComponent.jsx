import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService'

class ViewExcIEEEST5BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST5B: {}
        }
    }

    componentDidMount(){
        ExcIEEEST5BService.getExcIEEEST5BById(this.state.id).then( res => {
            this.setState({excIEEEST5B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST5B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEST5B.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kr:&emsp; </label>
                            <div> { this.state.excIEEEST5B.kr }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> tb1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tb1 }</div>
                        </div>
                        <div className = "row">
                            <label> tb2:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tb2 }</div>
                        </div>
                        <div className = "row">
                            <label> tc1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tc1 }</div>
                        </div>
                        <div className = "row">
                            <label> tc2:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tc2 }</div>
                        </div>
                        <div className = "row">
                            <label> tob1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tob1 }</div>
                        </div>
                        <div className = "row">
                            <label> tob2:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tob2 }</div>
                        </div>
                        <div className = "row">
                            <label> toc1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.toc1 }</div>
                        </div>
                        <div className = "row">
                            <label> toc2:&emsp; </label>
                            <div> { this.state.excIEEEST5B.toc2 }</div>
                        </div>
                        <div className = "row">
                            <label> tub1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tub1 }</div>
                        </div>
                        <div className = "row">
                            <label> tub2:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tub2 }</div>
                        </div>
                        <div className = "row">
                            <label> tuc1:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tuc1 }</div>
                        </div>
                        <div className = "row">
                            <label> tuc2:&emsp; </label>
                            <div> { this.state.excIEEEST5B.tuc2 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEST5B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEST5B.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST5BComponent
