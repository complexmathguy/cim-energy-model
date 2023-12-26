import React, { Component } from 'react'
import DateProxyService from '../services/DateProxyService';

class UpdateDateProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDateProxy = this.updateDateProxy.bind(this);

    }

    componentDidMount(){
        DateProxyService.getDateProxyById(this.state.id).then( (res) =>{
            let dateProxy = res.data;
            this.setState({
            });
        });
    }

    updateDateProxy = (e) => {
        e.preventDefault();
        let dateProxy = {
            dateProxyId: this.state.id,
        };
        console.log('dateProxy => ' + JSON.stringify(dateProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        DateProxyService.updateDateProxy(dateProxy).then( res => {
            this.props.history.push('/dateProxys');
        });
    }


    cancel(){
        this.props.history.push('/dateProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DateProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDateProxy}>Save</button>
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

export default UpdateDateProxyComponent
