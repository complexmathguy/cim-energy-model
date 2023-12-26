import React, { Component } from 'react'
import DecimalProxyService from '../services/DecimalProxyService';

class UpdateDecimalProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDecimalProxy = this.updateDecimalProxy.bind(this);

    }

    componentDidMount(){
        DecimalProxyService.getDecimalProxyById(this.state.id).then( (res) =>{
            let decimalProxy = res.data;
            this.setState({
            });
        });
    }

    updateDecimalProxy = (e) => {
        e.preventDefault();
        let decimalProxy = {
            decimalProxyId: this.state.id,
        };
        console.log('decimalProxy => ' + JSON.stringify(decimalProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        DecimalProxyService.updateDecimalProxy(decimalProxy).then( res => {
            this.props.history.push('/decimalProxys');
        });
    }


    cancel(){
        this.props.history.push('/decimalProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DecimalProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDecimalProxy}>Save</button>
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

export default UpdateDecimalProxyComponent
