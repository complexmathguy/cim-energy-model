import React, { Component } from 'react'
import DecimalProxyService from '../services/DecimalProxyService';

class CreateDecimalProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DecimalProxyService.getDecimalProxyById(this.state.id).then( (res) =>{
                let decimalProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDecimalProxy = (e) => {
        e.preventDefault();
        let decimalProxy = {
                decimalProxyId: this.state.id,
            };
        console.log('decimalProxy => ' + JSON.stringify(decimalProxy));

        // step 5
        if(this.state.id === '_add'){
            decimalProxy.decimalProxyId=''
            DecimalProxyService.createDecimalProxy(decimalProxy).then(res =>{
                this.props.history.push('/decimalProxys');
            });
        }else{
            DecimalProxyService.updateDecimalProxy(decimalProxy).then( res => {
                this.props.history.push('/decimalProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/decimalProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DecimalProxy</h3>
        }else{
            return <h3 className="text-center">Update DecimalProxy</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDecimalProxy}>Save</button>
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

export default CreateDecimalProxyComponent
