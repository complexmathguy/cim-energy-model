import React, { Component } from 'react'
import DCBreakerService from '../services/DCBreakerService';

class UpdateDCBreakerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCBreaker = this.updateDCBreaker.bind(this);

    }

    componentDidMount(){
        DCBreakerService.getDCBreakerById(this.state.id).then( (res) =>{
            let dCBreaker = res.data;
            this.setState({
            });
        });
    }

    updateDCBreaker = (e) => {
        e.preventDefault();
        let dCBreaker = {
            dCBreakerId: this.state.id,
        };
        console.log('dCBreaker => ' + JSON.stringify(dCBreaker));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCBreakerService.updateDCBreaker(dCBreaker).then( res => {
            this.props.history.push('/dCBreakers');
        });
    }


    cancel(){
        this.props.history.push('/dCBreakers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCBreaker</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCBreaker}>Save</button>
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

export default UpdateDCBreakerComponent
