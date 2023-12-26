import React, { Component } from 'react'
import BreakerService from '../services/BreakerService';

class UpdateBreakerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateBreaker = this.updateBreaker.bind(this);

    }

    componentDidMount(){
        BreakerService.getBreakerById(this.state.id).then( (res) =>{
            let breaker = res.data;
            this.setState({
            });
        });
    }

    updateBreaker = (e) => {
        e.preventDefault();
        let breaker = {
            breakerId: this.state.id,
        };
        console.log('breaker => ' + JSON.stringify(breaker));
        console.log('id => ' + JSON.stringify(this.state.id));
        BreakerService.updateBreaker(breaker).then( res => {
            this.props.history.push('/breakers');
        });
    }


    cancel(){
        this.props.history.push('/breakers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Breaker</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBreaker}>Save</button>
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

export default UpdateBreakerComponent
